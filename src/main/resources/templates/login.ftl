<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
Login page
<@c.page>
    <@l.login "/login" />
<a href="/registration">Add new user</a>
</@c.page>