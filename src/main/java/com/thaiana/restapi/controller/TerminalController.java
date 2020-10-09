package com.thaiana.restapi.controller;

import com.thaiana.restapi.model.Terminal;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/terminal")
public class TerminalController {

    @PostMapping(consumes = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<Terminal> post(@RequestBody String body) {
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/{logic}")
    public ResponseEntity<Terminal> get(@PathVariable("logic") int logic) {
        return ResponseEntity.ok(null);
    }

    @PutMapping(path = "/{logic}")
    public ResponseEntity<Terminal> put(@PathVariable("logic") int logic) {
        return ResponseEntity.ok(null);
    }

}
