# 4YOU com IA

Versão experimental do 4YOU em que a busca no Google (Jsoup + `split("FozYP\">")`) foi
substituída por uma API de IA (Gemini, gratuita, ou OpenAI). O questionário e a tabela de gêneros são os do projeto original.

## Como funciona

1. Você escolhe Filmes, Livros ou Músicas e responde às 5 perguntas (as mesmas do `TelaPerguntas.java`).
2. As respostas viram uma lista de gêneros (a mesma tabela do `Analise.java`).
3. `GeminiClient` (ou `OpenAiClient`) pede 3 sugestões à API e recebe um JSON com schema fixo.
4. `Capas` confere se cada obra existe e busca a capa:
   filmes e músicas no iTunes Search, livros na Open Library (nenhuma exige chave).
   Se a obra não for encontrada, o card mostra "⚠ não confirmado" (a IA pode inventar títulos).
5. "Outras sugestões" pede novos itens, passando os já mostrados para a IA não repetir.

## Requisitos

- JDK 17 ou superior
- Uma chave de API, de **um** dos dois provedores:
  - **Gemini (gratuito, sem cartão):** entre em https://aistudio.google.com com uma conta Google,
    abra "Get API key" e crie a chave.
  - OpenAI (pago, créditos pré-pagos a partir de US$ 5): https://platform.openai.com/api-keys

Se as duas variáveis estiverem definidas, o programa usa o Gemini.

## Rodando

Linux/macOS:

    export GEMINI_API_KEY="cole-sua-chave-aqui"
    javac -encoding UTF-8 -d out src/main/java/ia4you/*.java
    java -cp out ia4you.Main

Windows (PowerShell):

    $env:GEMINI_API_KEY="cole-sua-chave-aqui"
    javac -encoding UTF-8 -d out src/main/java/ia4you/*.java
    java -cp out ia4you.Main

Com Maven: `mvn compile exec:java`

Para só ver a interface, sem chave e sem internet: `java -cp out ia4you.Main --demo`

O plano gratuito do Gemini tem limite de requisições; se estourar, o programa mostra um aviso
e basta esperar um pouco. Se o modelo estiver sobrecarregado (erro 503), o programa tenta sozinho até 4 vezes
antes de mostrar o erro. No plano gratuito, o Google pode usar o conteúdo das requisições para
melhorar seus produtos (aqui são só gêneros e títulos, mas fica o aviso).

## Variáveis de ambiente

| Variável | Para quê |
|---|---|
| `GEMINI_API_KEY` | Chave do Gemini (gratuito) |
| `GEMINI_MODEL` | Modelo do Gemini (padrão `gemini-3.8-flash`; modelos antigos são encerrados com o tempo, então se der erro 404 troque por um modelo atual listado no AI Studio) |
| `OPENAI_API_KEY` | Chave da OpenAI (alternativa paga) |
| `OPENAI_MODEL` | Modelo da OpenAI (padrão `gpt-4o-mini`) |
| `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID` | Os mesmos `organization` e `project` do slide da aula |
| `GEMINI_BASE_URL`, `OPENAI_BASE_URL` | Endpoints alternativos |

Nunca coloque a chave dentro do código nem suba ela para o GitHub.

## Testes

`src/test/java/ia4you/Testes.java` sobe servidores falsos (OpenAI, Gemini, iTunes) e verifica o parser de JSON,
a tabela de gêneros, o pedido enviado aos dois provedores, o tratamento de erros (401, 429) e a verificação de títulos inventados:

    javac -encoding UTF-8 -d out src/main/java/ia4you/*.java src/test/java/ia4you/Testes.java
    java -cp out ia4you.Testes

## O que ficou de fora

Login, banco PostgreSQL, perfis e avaliações com estrelas do projeto original.
