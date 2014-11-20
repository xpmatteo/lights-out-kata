
Enumerare

    <#list people!"" as person>
      <tr>
        <td>${person.lastName}</td>
        <td>${person.firstName}</td>
        <td>${person.mobile}</td>
      </tr>
    </#list>

L'operatore di default ! fa accettare a Freemarker una lista nulla o vuota.

    ${foo!""}

Definizione macro

    <#macro cardImage source name>
      <img src="/images/cards/${source}.jpg" alt="${name}" width="100px"/>
    </#macro>

Uso macro

    <@cardImage source=card name=card />
  
