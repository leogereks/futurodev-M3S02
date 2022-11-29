package br.com.futurodev.api.controllers;

import br.com.futurodev.api.model.ProdutoModel;
import br.com.futurodev.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private ProdutoRepository produtoRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     *
     *
     */
    @RequestMapping(value = "/apresentacao/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello, " + name + ", estamos iniciando nosso trabalho com spring boot!";
    }

    @GetMapping(value = "/calcularmedia/{numeros}")
    @ResponseStatus(HttpStatus.OK)
    public String calcularmedia (@PathVariable int numUm, int numDois){
        int calcMedia = numUm+numDois/2;
        return "Os números selecionados foram: "+numUm+" e "+numDois+" sua média é "+calcMedia;
    }

    @RequestMapping(value = "/produto/{descricao}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String inserirProduto(@PathVariable String descricao){
        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        produtoRepository.save(produto);
        return "Produto "+descricao+" registrado com sucesso!";
    }

    @GetMapping(value = "/listarprodutos")
    @ResponseBody // retorna dados no corpo da resposta
    public ResponseEntity<List<ProdutoModel>> ListarProdutos(){
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return new ResponseEntity<List<ProdutoModel>>(produtos, HttpStatus.OK);
    }

    @PostMapping(value = "/produto/salvar") //mapeia url
    @ResponseBody // descreve resposta no body da requisicao
    public ResponseEntity<ProdutoModel> save(@RequestBody ProdutoModel produto){
        ProdutoModel prodResponse =  produtoRepository.save(produto);
        return new ResponseEntity<ProdutoModel>(prodResponse, HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/produto/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduct){ //param da request

        produtoRepository.deleteById(idProduct);
        return new ResponseEntity<String>("Produto deletado com sucesso",HttpStatus.OK);

    }

}
