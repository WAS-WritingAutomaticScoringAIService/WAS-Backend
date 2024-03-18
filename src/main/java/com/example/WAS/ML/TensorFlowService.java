package com.example.WAS.ML;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Service
public class TensorFlowService {

// 텍스트 데이터를 받아 Python 스크립트로 처리하고 결과를 반환합니다.
    public String predict(String textData) {

        // EC2 환경
        //ProcessBuilder processBuilder = new ProcessBuilder("/usr/bin/python3", "model_toUse.py", textData);
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "model_toUse.py", textData);
        // local 환경
        //ProcessBuilder processBuilder = new ProcessBuilder("C:\\Anaconda\\python.exe", "C:\\Users\\박영선\\Desktop\\코코톤\\spring\\WAS\\WAS\\src\\main\\java\\com\\example\\WAS\\ML\\model_toUse.py", textData);
        try {
            Process process = processBuilder.start();

            // 여기에서 타임아웃을 설정합니다. 타임아웃은 30초로 설정합니다.
            boolean finished = process.waitFor(20, TimeUnit.SECONDS);
            if (!finished) { // 타임아웃 발생시
                process.destroy(); // 프로세스 강제 종료
                return "실행 중 에러 발생 또는 타임아웃";
            }

//            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
//            String errorLine;
//            while ((errorLine = errorReader.readLine()) != null) {
//                System.out.println("Error: " + errorLine);
//            }

            // Python 스크립트의 출력을 읽어옵니다.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line);
                // System.out.println("line = " + line);
            }

            System.out.println("output = " + output);

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // Python 스크립트의 실행이 성공적으로 완료되었다면 결과를 반환합니다.
                return extractResult(output.toString());
            } else {
                // 에러 처리
                return "실행 중 에러 발생";
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Python 스크립트 실행 중 에러 발생", e);
        }
    }

    // 결과값 추출
    public String extractResult(String output) {
        // "Grade Category: " 문자열로 분리하여 배열을 얻습니다.
        String[] parts = output.split("Grade Category: ");

        // parts 배열의 마지막 요소가 원하는 값입니다.
        // 배열 길이를 확인하여 마지막 요소에 접근합니다.
        if (parts.length > 1) {
            // 결과값 반환
            return parts[parts.length - 1];
        } else {
            // "Grade Category: " 문자열이 없는 경우, 오류 메시지나 적절한 대응을 합니다.
            return "결과를 찾을 수 없습니다.";
        }
    }

}
