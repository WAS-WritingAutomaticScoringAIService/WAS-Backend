package com.example.WAS.ML;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TensorFlowService {

// 텍스트 데이터를 받아 Python 스크립트로 처리하고 결과를 반환합니다.
    public String predict(String textData) {
        ProcessBuilder processBuilder = new ProcessBuilder("python", "com/example/WAS/ML/model_toUse.py", textData);
        try {
            Process process = processBuilder.start();

            // Python 스크립트의 출력을 읽어옵니다.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println("output = " + output);

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // Python 스크립트의 실행이 성공적으로 완료되었다면 결과를 반환합니다.
                return output.toString();
            } else {
                // 에러 처리
                return "실행 중 에러 발생";
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Python 스크립트 실행 중 에러 발생", e);
        }
}


}
