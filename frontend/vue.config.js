const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // npm run build 의 타겟 디렉토리
  outputDir: '../backend/src/main/resources/static',
  // npm run serve
  devServer: {
    proxy: 'http://localhost:8080'
  }
})
