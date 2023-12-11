package com.oussemaouakad.surpriseme.Story;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

@Entity
@Getter
@Setter
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStory;
    @Column(nullable = false)
    private String name;
    private String generation;

    @PrePersist
    private void generateGeneration() throws IOException, InterruptedException {
        this.generation = generateStory(name);
     }
    private String generateStory(String prompt) throws IOException, InterruptedException {
        AppConfigService configService = new AppConfigService();

        double temperature = configService.getTemperature();
        int topK = configService.getTopK();

        String command = String.format("python C:\\Python\\see.py --temperature %.2f --top_k %d", temperature, topK);
        Process process = Runtime.getRuntime().exec(command);

        // Write the prompt to the Python process
        try (OutputStream outputStream = process.getOutputStream()) {
            outputStream.write(prompt.getBytes());
        }

        // Read the result from the Python process
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String result = reader.readLine();
        String resultWithoutSpaces = result.replaceAll("\\s", "");

        System.out.println("Generated Sentence:\n" + result +"\nwith :\nTemperature="+ temperature+"\nTop_K="+topK);

        // Wait for the process to exit
        process.waitFor();
        if (resultWithoutSpaces == null || resultWithoutSpaces.isEmpty()) {
            result = "Can't generate a sentence for this name";
            return result;
        } else {
            return result;
        }
    }

}
