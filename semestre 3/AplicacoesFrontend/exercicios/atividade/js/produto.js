function buscar(produto){
    var produto1 = {id:1,nome:"Garrafa 1", ano:2021};
    var produto2 = {id:2,nome:"Garrafa 2", ano:2021};
    var produto3 = {id:3,nome:"Garrafa 3", ano:2021};
    var produto4 = {id:4,nome:"Garrafa 4", ano:2021};
    var produto5 = {id:5,nome:"Garrafa 5", ano:2021};

    var produtos = [produto1,produto2,produto3,produto4,produto5];
    for(var i=0;i<produtos.length;i++){
        if(produtos[i].nome==produto){
            let produtoEncontrado=produtos[i];
            document.getElementById("dadoProduto").innerHTML=
            "ID: "+produtoEncontrado.id+"<br>"+
            "Nome: "+produtoEncontrado.nome+"<br>"+
            "Ano: "+produtoEncontrado.ano;
        }
    }
}