FROM nginx

RUN sed -i '1iupstream tomcat {\n    server mojarraajaxerrorclusteredenvironment_javaserver1_1:8080 weight=1;\n    server mojarraajaxerrorclusteredenvironment_javaserver2_1:8080 weight=1;\n    server mojarraajaxerrorclusteredenvironment_javaserver3_1:8080 weight=1;\n\n}' /etc/nginx/conf.d/default.conf
RUN sed -i '/location \/ [{]/  a\        proxy_pass http://tomcat; ' /etc/nginx/conf.d/default.conf
RUN sed -i '/location \/ [{]/,/[}]/ { /root/d; /index/d; }' /etc/nginx/conf.d/default.conf
