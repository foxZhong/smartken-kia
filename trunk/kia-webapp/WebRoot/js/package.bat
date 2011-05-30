del package.js
del package.min.js
for /f %%i in (js-list.txt) do type %%i >> package.js   
java -jar ../yuicompressor-2.4.6.jar --type js --charset utf-8  package.js -o package.min.js   

