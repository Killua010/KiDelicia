package br.com.kidelicia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kidelicia.dto.TableDto;


@Controller
@RequestMapping("/tables")
public class TableController extends AbstractController<TableDto>{

}
