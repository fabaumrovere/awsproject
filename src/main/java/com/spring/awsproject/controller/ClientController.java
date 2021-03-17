package com.spring.awsproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.awsproject.model.ClientEntity;
import com.spring.awsproject.service.ServiceInterface;

@Controller
public class ClientController {

   @Autowired
   ServiceInterface<ClientEntity,Long> service;

   @GetMapping
   @RequestMapping( value = "/clients" )
   public ModelAndView getClients() {
      ModelAndView mv = new ModelAndView( "clients" );
      List<ClientEntity> findAll = service.findAll();
      mv.addObject("clients", findAll.stream().sorted((a, b) -> Long.compare(a.getId(), b.getId())).collect(Collectors.toList()));
      return mv;
   }

   @GetMapping
   @RequestMapping( value = "/client/{id}" )
   public ModelAndView getclient( @PathVariable Long id) {
      ModelAndView mv = new ModelAndView( "client" );
      ClientEntity find = service.findById(id);
      mv.addObject("client", find);
      return mv;
   }

   @GetMapping
   @RequestMapping( value = "/newclient" )
   public String getClientForm() {
      return "clientForm";
   }

   @GetMapping
   @RequestMapping( value = "/mergeclient/{id}" )
   public ModelAndView getMergeClientForm( @PathVariable Long id) {
      ModelAndView mv = new ModelAndView( "clientFormAlt" );
      ClientEntity find = service.findById(id);
      mv.addObject("client", find);
      return mv;
   }

   @DeleteMapping
   @RequestMapping( value = "/delete/{id}" )
   public String deleteClientForm( @PathVariable Long id) {
      service.delete(id);
      return "redirect:/clients";
   }

   @RequestMapping( value = "/newclient", method = RequestMethod.POST )
   public String saveClient( @Valid ClientEntity client, BindingResult result, RedirectAttributes attributes) {

      if( result.hasErrors() ) {
         attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");

         if( client.getId() != null ) {
            return "redirect:/mergeclient/" + client.getId();
         }
         return "redirect:/newclient";
      }

      client.setData( LocalDate.now() );

      service.save(client);

      return "redirect:/clients";
   }
}
