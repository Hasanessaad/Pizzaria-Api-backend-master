package br.com.contas.demo.service;

import br.com.contas.demo.dto.AdressDTO;
import br.com.contas.demo.dto.SizeDTO;
import br.com.contas.demo.entity.Adress;
import br.com.contas.demo.entity.Size;
import br.com.contas.demo.repository.Adress_repository;
import br.com.contas.demo.repository.SizeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SizeService {


    private SizeRepository repository;

    private Adress_repository adressRepository;

    public SizeService(SizeRepository repository, Adress_repository adressRepository) {
        this.repository = repository;
        this.adressRepository = adressRepository;
    }


    public List<Size> Findall() { return repository.findAll();}


    public ResponseEntity<Size> update (Long id, SizeDTO sizeDTO){
        Optional<Size> Sizee_update = repository.findById(id);
        if ( Sizee_update.isEmpty()) {
            throw new RuntimeException("Sizee nao existe");
        } else {
            Size Size = Sizee_update.get();
            BeanUtils.copyProperties(sizeDTO,Size);
            repository.save(Size);

            return new ResponseEntity<Size>(HttpStatus.OK);

        }

    }

    public ResponseEntity<Size> create( SizeDTO sizeDTO){

        try {
            Size Sizee = new Size();
            BeanUtils.copyProperties(sizeDTO, Sizee);
            System.out.println("size foi cadastrado");
            System.out.println(Sizee.getTamanho());
            System.out.println(Sizee.getNsabor());


            repository.save(Sizee);

            return new ResponseEntity<Size>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause().getMessage()) ;
        }

    }



    public ResponseEntity<Object> delete ( Long id){
        Optional<Size> Sizee_optional = repository.findById(id) ;
        if ( Sizee_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Size Sizee = Sizee_optional.get();
            repository.delete(Sizee);
            return ResponseEntity.ok("Sizee deletado com sucesso");


        }

    }





}
