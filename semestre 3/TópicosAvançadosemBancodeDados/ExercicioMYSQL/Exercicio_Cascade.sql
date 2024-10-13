/*Exercícios sobre o Uso de CASCADE
1 . Exclusão em Cascata: 
Exclua um cliente e todos os pedidos, detalhes dos pedidos e pagamentos associados a ele.
2. Atualização em Cascata: 
Atualize o ID de uma categoria de produto e observe como isso afeta os produtos 
associados a ela.
3. Exclusão em Cascata de Produtos: 
Exclua um produto e todos os detalhes de pedidos associados a ele.
4. Atualização em Cascata de Pedidos: Atualize o ID de um pedido
verifique se os detalhes do pedido e os pagamentos também são atualizados. 
Exclusão de Categorias: Exclua uma categoria
 verifique se os produtos associados são atualizados corretamente para NULL.*/
 /*Exclusão*/
 
 DELETE FROM clientes WHERE id = 1;
 /*Verificando registros*/
 SELECT * FROM pedidos WHERE cliente_id = 1;          -- Deve retornar nenhum registro
SELECT * FROM detalhes_pedido WHERE pedido_id IN (SELECT id FROM pedidos WHERE cliente_id = 1);  -- Deve retornar nenhum registro
SELECT * FROM pagamentos WHERE pedido_id IN (SELECT id FROM pedidos WHERE cliente_id = 1);     -- Deve retornar nenhum registro
/*Atualizando*/
UPDATE categorias SET id = 10 WHERE id = 1;
SELECT * FROM produtos WHERE categoria_id = 10;    -- Deve retornar os produtos que agora têm a nova categoria


