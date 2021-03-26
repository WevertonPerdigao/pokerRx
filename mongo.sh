docker run -d --restart=always \
  -v /home/pokerRx/mongodb:/data/db \
  -v /home/pokerRx/mongodb/mongoconfig:/data/configdb \
  -e TZ=America/Manaus --name=poker_mongo mongo:4