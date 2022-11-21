FROM nginx:stable

COPY nginx.conf /etc/nginx/nginx.conf
COPY --chown=nginx:nginx dist /usr/share/nginx

EXPOSE 80