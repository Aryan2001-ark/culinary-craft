# 🍽️ Culinary Craft

Culinary Craft is a personal backend project built with Java Spring Boot 3 and MongoDB. It allows authenticated users to create, search, and manage detailed Indian recipes with support for role-based access and password encryption.

---

## 🚀 Features

- ✅ Recipe creation, search, and retrieval with full CRUD support
- ✅ User authentication with Basic Auth (Spring Security)
- ✅ Password encryption (BCrypt) with account-level control
- ✅ MongoDB as the primary data store
- ✅ RESTful APIs tested via Postman & cURL
- ✅ Field-level customization like totalServings, timestamps, custom UUIDs

---

## 🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot 3.x
- **Database:** MongoDB (local or Compass)
- **Security:** Spring Security (Basic Auth + BCrypt)
- **Tools:** Postman, cURL, IntelliJ IDEA, Lombok

---

## 📁 Folder Structure

```text
src/
├── controller        # API endpoints
├── service           # Business logic
├── repository        # MongoDB repositories
├── model             # Recipe and User models
├── util              # UUID generator, helpers
├── config            # Security configuration
└── security          # Custom authentication handlers
```


---

## 🔐 Sample API Endpoints

### 👤 Register a New User

```
http
POST /api/users/register
Content-Type: application/json

{
  "username": "testuser",
  "password": "password123"
}
```
### Returns:
``` You are successfully registered to our system.```

### 🍽️ Add a New Recipe (Request Format Example)

```
POST /api/recipes
Authorization: Basic base64(testuser:password123)
Content-Type: application/json

{
  "name": "Dish Name",
  "description": "Short description of the recipe",
  "ingredients": ["ingredient 1", "ingredient 2", "ingredient 3"],
  "steps": ["Step 1", "Step 2", "Step 3"],
  "cuisine": "Region or cuisine type (e.g., South Indian)",
  "prepTimeInMinutes": 30,
  "cookTimeInMinutes": 45,
  "totalServings": "4",
  "createdBy": "Creator's name"
}
```
### 🔍 Search Recipes by Name

```
http
GET /api/recipes/recipeName/{name}
Authorization: Basic base64(testuser:password123)
```

### Example:
```
GET /api/recipes/recipeName/masala
```
### Return:

```
Returns a list of recipes whose names contain "masala" (case-insensitive).

```

###  Test Auth with curl
```
curl -u testuser:password123 http://localhost:8080/api/recipes
```

## 🧪 How to Run Locally
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/culinary-craft.git cd culinary-craft

2. **Start MongoDB**
   * Make sure MongoDB is running locally at `mongodb://localhost:27017/culinarycraft`.
   * You can use MongoDB Compass or terminal.

3. **Run the Spring Boot application**
   * Open in IntelliJ IDEA or run: `./mvnw spring-boot:run`.

4. **Access the API:**
   * Open Postman or cURL to test the endpoints.
   * Use `http://localhost:8080/api/recipes` for recipe-related operations.

## 🙋 Author
**Aryan Kumar**  
📧 [ark.202003@gmail.com](mailto:ark.202003@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/aryankr1010)