# Delivery JáChega — Projeto 12

Atividade de modelagem orientada a objetos e Java. Um cliente escolhe pratos de um restaurante, monta um pedido e acompanha sua entrega. O modelo mostra abstração, encapsulamento, herança e polimorfismo, além de associação, agregação e composição.

O `Pedido` protege o total, a taxa e o status; recebe no máximo um entregador. `ClienteAssinante` tem entrega gratuita quando o valor dos itens atinge o mínimo configurado. Os itens pertencem ao pedido, enquanto pratos permanecem no cardápio independentemente dos pedidos.

## Arquivos

- `modelagem/diagrama-classes.drawio`: diagrama editável no [draw.io](https://app.diagrams.net).
- `modelagem/diagrama-classes.md`: mesma modelagem em Mermaid, para leitura no GitHub.
- `java/`: classes Java e uma demonstração em `Principal`.
- `referencias/`: briefing, entrevista e plano originais do professor.

## Executar

Com JDK instalado, na raiz desta pasta:

```bash
javac -d saida java/*.java
java -cp saida Principal
```

O programa é de memória, sem interface gráfica ou banco de dados. Os valores de taxa e do mínimo de entrega gratuita são exemplos configurados em `Principal`, pois a entrevista não fornece números.

## Decisões para o grupo revisar

- O pedido começa em `RECEBIDO`; itens só são acrescentados nessa fase. O cancelamento é permitido antes de `ENTREGUE` e remove os itens do pedido.
- Um entregador pode transportar vários pedidos ao longo do tempo; cada pedido admite zero ou um até a atribuição.
- O valor do pedido é a soma dos subtotais mais a taxa calculada pelo tipo de cliente. O preço do prato é registrado no item quando ele é adicionado.
- Não há avaliação, rota, autenticação nem pagamento nesta entrega. São temas de encontros posteriores.

## Divisão sugerida da revisão em grupo

Uma pessoa confere classes e atributos com a entrevista; outra valida setas e multiplicidades; outra executa o Java e confere as regras; todos revisam o resultado final juntos. Preencham os nomes do grupo e decidam conjuntamente as lacunas antes de entregar.

## Entrega

Cada integrante envia individualmente ao Google Forms seu nome, RA e **o mesmo link deste repositório**. O link do formulário não foi fornecido aqui.
