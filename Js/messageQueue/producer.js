const http = require("http");
const { Queue } = require("bullmq");

const emailQueue = new Queue("EMAIL_QUEUE");

async function sendNotification() {
  const message = {
    timeStamp: new Date().toLocaleTimeString(),
    data: "Hello reader hope you are enjoying this app.",
  };
 
  const response = await emailQueue.add("EMAIL_QUEUE", message);
  console.log(message, response.id);
}

const  server = http.createServer((req, res) => {
  sendNotification();
  res.writeHead(200, { 'Content-Type': 'application/json' });
  res.end(JSON.stringify({
    data: 'Hello World!',
  }));
});

server.listen(3000,()=>{
 console.log("🧲server started");
})

sendNotification();
console.log("producer started");
