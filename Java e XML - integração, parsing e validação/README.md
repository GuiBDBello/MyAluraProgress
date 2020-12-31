# Java e XML: integração, parsing e validação

## Aula 01 - Representando dados de forma eficiente

### Atividade 01 - Conhecendo o formato XML:

- Formato definido na década de 90 pelo W3C para realizar a comunicação entre sistemas diferentes.
- Organiza informações de forma hierárquica.

### Atividade 02 - Acessando tags de um XML:

- `Document` é o arquivo XML.
- `Element` é a *tag* XML.
- As classes Java utilizadas para trabalhar com XML são provenientes do pacote `org.w3c.dom`.
- **Ex.:**
```
DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = fabrica.newDocumentBuilder();
Document document = builder.parse("src/vendas.xml");

NodeList formasDePagamento = document.getElementsByTagName("formaDePagamento");
Element fdp = (Element) formasDePagamento.item(0);
String formaDePagamento = fdp.getTextContent();
```
- Os elementos do XML podem ser acessados através de `getElementsByTagName("tagName")`, que retorna um `NodeList`.
- Cada elemento dessa lista é representado por uma instância de `Node`. É possível realizar o *cast* de `Node` para `Element`.
- `getTextContent()` retorna o conteúdo do texto contido dentro da *tag*.
- O Java possui diversas especificações, que são conjuntos de interfaces cujo objetivo é desempenhar alguma função. Para manipular XML, temos uma especificação chamada JAXP (Java API for XML Processing).

### Atividade 04 - Criar e acessar atributos:

- E se quisermos incluir também a moeda em que a venda foi realizada? Perceba que a moeda é mais uma informação sobre os dados da venda, como uma meta-informação.
- **Ex.:** (criar um atributo no XML) 
```
<venda moeda="real">
</venda>
```
- O `Document` é uma referência para o "elemento-raíz" do XML.
- **Ex.:** (acessar o atributo com código Java)
```
Element venda = document.getDocumentElement();
String moeda = venda.getAttribute("moeda");
```
