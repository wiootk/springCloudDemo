const Koa = require('koa')
const app = new Koa()
const Router = require('koa-router')
const router = new Router()
var  request = require('superagent');
const SERVICE = 'compute-service'
// 调取其他服务
// http://localhost:8004/hi
  router.get('/hi',async  ctx => {
    var res=await request.get('http://localhost:8003/compute-service/hi?name=forezp').then(function(res){
        console.log(res.status,res.text);return res;})
    ctx.body=res.text;
  })
  router.get('/health', ctx => {
      ctx.body ={    status: 'UP'}
  })
  var books=[{"id":1,"name":"book1"},{"id":2,"name":"book2"},{"id":3,"name":"book3"}]
// 提供服务
  router.get('/books/:id', ctx => {
      console.log(ctx.params.id);
      ctx.body =books;
  })
app .use(router.routes()).use(router.allowedMethods());
app.listen(8004)
console.log(`koa2 已启动 , 端口 : 8004`)