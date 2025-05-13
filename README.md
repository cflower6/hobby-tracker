# OtakuHub 🎮✨  
A personal hobby tracker app for anime, games, and Pokémon TCG built with **Kotlin** and **Ktor**.

---

## 🧠 Project Summary  
**OtakuHub** helps you track your favorite hobbies in one place. Whether you're watching anime, playing games, or collecting Pokémon cards, this MVP lets you log, update, and view your current interests with a clean and responsive API.

---

## 🚀 MVP Features  
- 📺 **Anime Tracking**: Add and retrieve your currently watching list  
- 🎮 **Game Backlog**: Keep tabs on games you're playing or want to play  
- 🃏 **Pokémon TCG Tracker**: Store card names or sets you're collecting  
- 🔐 JWT-based Auth for private endpoints  
- 🌐 RESTful API built using [Ktor](https://ktor.io)

---

## 🛠️ Tech Stack  
- **Backend**: Kotlin, Ktor  
- **Database**: PostgreSQL  
- **ORM**: Exposed or Ktorm  
- **Authentication**: JWT  
- **Dev Tools**: Gradle, Docker (optional)

---

## 📁 Folder Structure  
<pre>
/src
 └── /main
     ├── /kotlin
     │   └── com.otakuhub
     │       ├── Application.kt
     │       ├── /routes
     │       ├── /models
     │       ├── /services
     │       └── /config
     └── /resources
         └── application.yaml
</pre>

---

## ⚙️ Configuration  
Set environment variables or fill in `application.yaml` with:

```yaml
ktor:
  deployment:
    port: 8080
  application:
    modules:
      - com.otakuhub.ApplicationKt.module

database:
  url: jdbc:postgresql://localhost:5432/otakuhub
  user: your_db_user
  password: your_db_password

jwt:
  secret: your_jwt_secret
  issuer: otakuhub.io
  audience: otakuhub_users
