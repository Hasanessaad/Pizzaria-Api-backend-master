package br.com.contas.demo.controller;

import br.com.contas.demo.dto.SizeDTO;
import br.com.contas.demo.entity.Size;
import br.com.contas.demo.service.SizeService;
import br.com.contas.demo.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/size")
public class SizeController {
    //aaaa
    @Autowired
    private SizeService service;

    @GetMapping("/findall")

    public List<Size> Findall() {
        return service.Findall();
    }

    @PostMapping
    public ResponseEntity<Size> create(@Valid @RequestBody SizeDTO sizeDTO) {
        return service.create(sizeDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<Size> update(@RequestBody SizeDTO sizeDTO, @RequestParam Long id){
        return service.update(id, sizeDTO);
    }

    @DeleteMapping
    public ResponseEntity<Object> Delete(@RequestParam Long id){
        return service.delete(id);
    }
}
