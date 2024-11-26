db = db.getSiblingDB("CustomerOrderDB");

db.createCollection("customer");
db.createCollection("order");
db.createCollection("login");
db.createUser({
  user: "root",
  pwd: "UPTC2024",
  roles: [{ role: "readWrite", db: "CustomerOrderDB" }],
});
