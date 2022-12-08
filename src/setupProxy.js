const {createProxyMiddleware} = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        createProxyMiddleware('/api',{
            target:"81.68.102.92:8090",
            changeOrigin:true,
            pathRewrite:{'^/api':''}
        })
    )
}