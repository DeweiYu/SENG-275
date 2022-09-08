## Lab 8
**Console output**
```
GET /api/v2/pokemon/snorlax HTTP/1.1
User-Agent: PostmanRuntime/7.29.0
Accept: */*
Postman-Token: fbbe3fe2-07c8-4c42-ac77-a9f2496478fc
Host: pokeapi.co
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
 
HTTP/1.1 200 OK
Date: Fri, 22 Jul 2022 18:27:48 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
alt-svc: h3=":443"; ma=86400, h3-29=":443"; ma=86400
access-control-allow-origin: *
Cache-Control: public, max-age=86400, s-maxage=86400
etag: W/"4a052-cRsK7VsOY9lEz85BPZ9ZAR5hK0s"
function-execution-id: 08uji6wv5ouj
strict-transport-security: max-age=31556926
x-cloud-trace-context: a92b89c7dd113f5a497beb715121db66
x-country-code: CA
x-powered-by: Express
x-served-by: cache-yyc1430022-YYC
x-cache: MISS
x-cache-hits: 0
x-timer: S1658514468.773281,VS0,VE543
vary: Accept-Encoding,cookie,need-authorization, x-fh-requested-host, accept-encoding
CF-Cache-Status: EXPIRED
Expect-CT: max-age=604800, report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=ubzZklKXgSmQ2Oxc6uTf0WV%2FW5KsknfQDSKl3V8%2BpVpJA8IYpegcCpI55FiE6zejVvappJEtfsdeUkcSMliP4DqjjpxyM5Lv6uZcXFcCkjEaeeQ5m1GCY3PiGvCB"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 72ee3b7f6c59137a-YVR
Content-Encoding: br
```
5 API test
```
// Test 1 ability
pm.test("effect", function () {
    pm.expect(pm.response.text()).to.include("Hat im Kampf keinen Effekt.");
});
// Test 2 characteristic
pm.test("description", function () {
    pm.expect(pm.response.text()).to.include("맷집이 강함");
});
//Test 3 location
pm.test("Name matches string", function () {
    pm.expect(pm.response.text()).to.include("sinnoh-route-212-east-towards-pastoria-city");
});
//Test4 location
pm.test("name", function () {
    pm.expect(pm.response.text()).to.include("diamond");
});
//Test5 ability
 pm.test("name", () => {
   pm.expect(pm.response.text()).to.include("en");
});
```
**Tests for creating, patching, and deleting a resource**
```
//Create a resource 
fetch('https://jsonplaceholder.typicode.com/POST', {
  method: 'POST',
  body: JSON.stringify({
    title: 'level1',
    body: 'knight',
    userId: 1,
  }),
  headers: {
    'Content-type': 'application/json; charset=UTF-8',
  },
})
  .then((response) => response.json())
  .then((json) => console.log(json));

//Patch a resources
fetch('https://jsonplaceholder.typicode.com/posts/3', {
  method: 'PATCH',
  body: JSON.stringify({
    title: 'lv1,
  }),
  headers: {
    'Content-type': 'application/json; charset=UTF-8',
  },
})
  .then((response) => response.json())
  .then((json) => console.log(json));

//Deleting a resources
fetch('https://jsonplaceholder.typicode.com/posts/3', {
  method: 'DELETE',
});

```

