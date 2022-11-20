FROM node:16
WORKDIR /usr/src/app

FROM nginx:alpine
COPY --from=node /dist/testapp /usr/share/nginx/html
