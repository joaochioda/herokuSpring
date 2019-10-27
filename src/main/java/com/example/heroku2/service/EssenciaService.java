package com.example.heroku2.service;

import com.example.heroku2.essenciaStatus;
import com.example.heroku2.model.CadastrarTudo;
import com.example.heroku2.model.Essencia;
import com.example.heroku2.model.Marca;
import com.example.heroku2.model.Message;
import com.example.heroku2.repository.EssenciaRepository;
import com.example.heroku2.repository.MarcaRepository;
import com.example.heroku2.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EssenciaService {

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private EssenciaRepository essenciaRepository;
    @Autowired
    private MessageRepository messageRepository;

    public Essencia addEssencia(Essencia essencia) {
        essencia.setStatus(essenciaStatus.WAITTING);
        return essenciaRepository.save(essencia);
    }

    public Essencia getEssenciaById(Long id) {
        Optional<Essencia> essencia = essenciaRepository.findById(id);
        if(essencia.isPresent()){
            return essencia.get();
        }
        return null;
    }

    public List<Essencia> getAllEssencia() {
        List<Essencia> essencias = new ArrayList<>();
        essenciaRepository.findAll().forEach(essencias::add);
        return essencias;
    } 

    public void cadastrarTudo(List<CadastrarTudo> cadastrarTudo) {
        for(CadastrarTudo cadastra:cadastrarTudo) {
            Marca marcas = new Marca(cadastra.getMarca(),cadastra.getImage());
           Long id = marcaRepository.save(marcas).getId();

          for(Essencia allEssencia:cadastra.getEssencias()) {
           Optional<Marca> marca = marcaRepository.findById(id);
              if(marca.isPresent()) {
                  Essencia ess = new Essencia(allEssencia.getNome(),marca.get(),allEssencia.getImage(),essenciaStatus.CREATED);
                  essenciaRepository.save(ess);
              }
          }
        }
    }

    public Essencia addMessage (Message message, Long id) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format( new Date()   );
        message.setDate(dateString);
    Long idMessage = messageRepository.save(message).getId();
    Optional<Message> mes = messageRepository.findById(idMessage);

        Optional<Essencia> essencia = essenciaRepository.findById(id);
    if(essencia.isPresent() && mes.isPresent()){
        List<Message> listMessage = essencia.get().getMessage();
        listMessage.add(mes.get());
        essencia.get().setMessage(listMessage);
        essenciaRepository.save(essencia.get());

        return essencia.get();
    }
    return essencia.get();
    }

    public Essencia deleteEssencia (Long id) {
        Optional<Essencia> es = essenciaRepository.findById(id);
        if(es.isPresent()) {
            essenciaRepository.delete(es.get());
        }
        return null;
    }
}
