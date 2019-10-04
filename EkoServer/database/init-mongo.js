db.createUser(
    {
        user: "root",
        pwd: "root",
        roles: [
            {
                role: "readWrite",
		        db: "ekodb"
	        }
        ]
    }
)

db.createCollection("productos")
