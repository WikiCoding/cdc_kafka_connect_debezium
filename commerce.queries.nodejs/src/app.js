const express = require("express");
const app = express();
const cors = require("cors");
const productsRouter = require("./routers/productsRouter");

const corsOptions = {
    origin: true,
};

app.use(express.json());
app.use(cors(corsOptions));
app.use(productsRouter);

app.listen(process.env.APP_PORT, () => {
    console.log(`Server listening on port ${process.env.APP_PORT}`);
});