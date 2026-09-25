# Diagrama de classes — Delivery JáChega

Abra `diagrama-classes.drawio` no draw.io para editar a versão gráfica. Os rótulos nas duas pontas indicam multiplicidade; os losangos ficam do lado do todo.

```mermaid
classDiagram
    class Cliente {
        <<abstract>>
        -String nome
        -String telefone
        -String endereco
        +getNome() String
        +taxaEntrega(valorItens: double, taxaBase: double)* double
    }
    class ClienteComum {
        +taxaEntrega(valorItens: double, taxaBase: double) double
    }
    class ClienteAssinante {
        -double valorMinimoEntregaGratis
        +taxaEntrega(valorItens: double, taxaBase: double) double
    }
    class Restaurante {
        -String nome
        -String endereco
        -List~Prato~ pratos
        +adicionarPrato(prato: Prato) void
        +contemPrato(prato: Prato) boolean
    }
    class Prato {
        -String nome
        -double preco
        +obterPreco() double
    }
    class Pedido {
        -Cliente cliente
        -Restaurante restaurante
        -Entregador entregador
        -List~ItemPedido~ itens
        -double taxaBase
        -double taxaEntrega
        -double total
        -String status
        +adicionarItem(prato: Prato, quantidade: int) void
        +atribuirEntregador(entregador: Entregador) void
        +iniciarPreparo() void
        +sairParaEntrega() void
        +entregar() void
        +cancelar() void
        +calcularTotal() double
    }
    class ItemPedido {
        -Prato prato
        -int quantidade
        -double precoUnitario
        +calcularSubtotal() double
    }
    class Entregador {
        -String nome
        -String telefone
        +realizarEntrega(pedido: Pedido) void
    }
    Cliente <|-- ClienteComum
    Cliente <|-- ClienteAssinante
    Cliente "1" -- "0..*" Pedido : faz
    Restaurante "1" -- "0..*" Pedido : prepara
    Pedido "0..*" -- "0..1" Entregador : é levado por
    Pedido "1" *-- "0..*" ItemPedido : contém
    Restaurante "1" o-- "0..*" Prato : agrupa
    ItemPedido "0..*" --> "1" Prato : referencia
```

`0..*` itens permite criar um pedido antes de adicionar pratos; `iniciarPreparo()` exige pelo menos um. `0..1` entregador permite o estado anterior à atribuição. Quando um pedido é cancelado, sua lista de itens é limpa. O prato permanece no restaurante.
