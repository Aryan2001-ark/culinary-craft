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
- ✅ Gateway routing: All endpoints are under `/culinary-craft`
- ✅ Admin-only user deletion endpoint
- ✅ User registration checks:
  - Username must be more than 8 characters
  - Password must be at least 8 characters, contain at least 1 lowercase letter, 1 uppercase letter, and 1 special character
  - Duplicate usernames are not allowed

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

## 🔐 API Endpoints (Gateway: `/culinary-craft`)

### 👤 User Endpoints

- **Register a New User**
  ```
  POST /culinary-craft/users/register
  Content-Type: application/json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```
  Returns: `You are successfully registered to our system.`

- **Delete a User (Admin Only)**
  ```
  DELETE /culinary-craft/users/delete?usernameToDelete={username}&requesterUsername={adminUsername}
  ```
  Only users with the ADMIN role can delete other users. Both usernames are passed as query parameters.

### 🍽️ Recipe Endpoints

- **Add a New Recipe**
  ```
  POST /culinary-craft/recipes
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

- **Bulk Add Recipes**
  ```
  POST /culinary-craft/recipes/bulk
  ```

- **Get All Recipes**
  ```
  GET /culinary-craft/recipes
  ```

- **Get Recipe by ID**
  ```
  GET /culinary-craft/recipes/{id}
  ```

- **Search Recipes by Name**
  ```
  GET /culinary-craft/recipes/recipeName/{name}
  ```

- **Delete Recipe**
  ```
  DELETE /culinary-craft/recipes/{id}
  ```

### 🩺 Health Check Endpoint
- **Health Check**
  ```
  GET /culinary-craft/health
  ```

---

## 🧪 How to Run Locally
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/culinary-craft.git
   cd culinary-craft
   ```
2. **Start MongoDB**
   * Make sure MongoDB is running locally or update your `application-local.yml` for Atlas.
3. **Run the Spring Boot application**
   * Open in IntelliJ IDEA or run: `./mvnw spring-boot:run`.
4. **Access the API:**
   * Use Postman or cURL to test the endpoints.
   * All endpoints are now under `http://localhost:8081/culinary-craft`

---

## 🙋 Author
**Aryan Kumar**  
📧 [ark.202003@gmail.com](mailto:ark.202003@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/aryankr1010)