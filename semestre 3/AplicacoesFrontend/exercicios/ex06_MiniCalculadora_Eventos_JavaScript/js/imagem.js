// Função chamada ao clicar na imagem
function alteraImagem() {
    // Pega a imagem pelo ID
    var imagem = document.getElementById("imagem");

    // Troca o caminho da imagem (precisa garantir que o arquivo existe)
    imagem.src = "assets/calcular.png";

    // Mostra o caminho novo em um alerta
    alert(imagem.src);
}
