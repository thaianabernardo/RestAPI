package com.thaiana.restapi.service;

import com.thaiana.restapi.model.Terminal;
import com.thaiana.restapi.repository.TerminalRepository;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {

    public TerminalRepository repository;

    public TerminalService(TerminalRepository terminalRepository) {
        this.repository = terminalRepository;
    }

    public Terminal parseTerminal(String data) {
        Terminal terminal = new Terminal();
        String[] parts = data.split(";");

        terminal.setLogic(Integer.parseInt(parts[0]));
        terminal.setSerial(parts[1]);
        terminal.setModel(parts[2]);
        terminal.setSam(Integer.parseInt(parts[3]));
        terminal.setPtid(parts[4]);
        terminal.setPlat(Integer.parseInt(parts[5]));
        terminal.setVersion(parts[6]);
        terminal.setMxr(Integer.parseInt(parts[7]));
        terminal.setMxf(Integer.parseInt(parts[8]));
        terminal.setVerfm(parts[9]);

        return terminal;
    }

    public boolean validateJson(String jsonString) {
        JSONObject jsonSchema = new JSONObject(new JSONTokener(TerminalService.class.getResourceAsStream("/schema.json")));
        Schema schemaValidator = SchemaLoader.load(jsonSchema);
        try {
            schemaValidator.validate(new JSONObject(jsonString));
            return true;
        } catch (Exception e) {
            System.out.println(" message is :"+ e.getMessage());
        }
        return false;
    }

}
