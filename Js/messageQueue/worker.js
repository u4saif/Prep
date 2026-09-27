const { Worker } = require("bullmq");
const DELAY_TIME = 9000;

const delay = (ms) => {
  return new Promise((res, rej) =>
    setTimeout(() => {
      res();
    }, ms),
  );
};

function ProcessEmail() {
  const worker = new Worker(
    "EMAIL_QUEUE",
    async (job) => {
      console.log("started", job.id);
      await delay(DELAY_TIME);
      console.log("email sent to id", job.id);
    },
    {
      connection: {
        host: "localhost",
        port: 6379,
      },
    },
  );
}

ProcessEmail();
