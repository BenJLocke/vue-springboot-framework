module.exports = {
    publicPath: './',
    productionSourceMap: false,
    devServer: {
        proxy: {
            '/api':{
                target:'http://jsonplaceholder.typicode.com',
                changeOrigin:true,
                pathRewrite:{
                    '/api':''
                }
            },
            '/ms':{
                target: 'https://www.easy-mock.com/mock/592501a391470c0ac1fab128',
                changeOrigin: true
            },
			'/login':{
                target: 'http://localhost:8080',
                changeOrigin: true
            },
            '/service':{
                target: 'http://localhost:8080',
                changeOrigin: true
            }
        }
    }
}