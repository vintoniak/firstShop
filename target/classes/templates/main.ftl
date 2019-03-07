<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<@l.logout/>
<form method="post">
    <input type="text" name="type" placeholder="Enter type"/>
    <input type="text" name="name" placeholder="Enter name"/>
    <input type="text" name="productNumber" placeholder="Enter productNumber "/>
    <input type="text" name="numberOfGoods" placeholder="Enter numberOfGoods"/>
    <input type="text" name="unitPrice" placeholder="Enter unitPrice "/>
    <input type="text" name="totalPrice" placeholder="Enter totalPrice "/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Add</button>

</form>



<form method="post" action="filter">
    <input type="text" name="type" />
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Filter</button>
</form>

<div> Список з бази даних </div>
<#list messages as message>
<div>
    <span>${message.id}</span>
    <span>${message.type}</span>
    <b>${message.name}</b>
    <i>${message.productNumber}</i>

    <i>${message.numberOfGoods}</i>
    <i>${message.unitPrice}</i>
    <i>${message.totalPrice}</i>
    <strong>${message.authorName}</strong>

</div>
<#else>
No message
</#list>

    </@c.page>