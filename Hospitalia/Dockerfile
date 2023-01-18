FROM node:latest as node

WORKDIR /Hospitalia

COPY package*.json .

RUN npm install

COPY . .

RUN ng build --prod

EXPOSE 4200

CMD ["npm", "start"]
