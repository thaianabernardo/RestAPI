package com.thaiana.restapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thaiana.restapi.model.Terminal;
import com.thaiana.restapi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/terminal")
public class TerminalController {

    @Autowired
    TerminalService terminalService;

    @PostMapping(consumes = MediaType.TEXT_HTML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Terminal> post(@RequestBody String body) {
        Terminal terminal = terminalService.parseTerminal(body);
        terminal = terminalService.repository.save(terminal);
        return ResponseEntity.ok().body(terminal);
    }

    @GetMapping(path = "/{logic}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Terminal> get(@PathVariable("logic") int logic) {
        return terminalService.repository.findById(logic)
                .map(terminal -> ResponseEntity.ok().body(terminal))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{logic}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Terminal> put(@PathVariable("logic") int logic, @RequestBody String terminal) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Terminal newTerminal = mapper.readValue(terminal, Terminal.class);
        if(logic != newTerminal.getLogic())
            return ResponseEntity.badRequest().build();

        return terminalService.repository.findById(logic)
                .map(oldTerminal -> {
                    oldTerminal = newTerminal;
                    Terminal updatedTerminal = terminalService.repository.save(oldTerminal);
                    return ResponseEntity.ok().body(updatedTerminal);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
