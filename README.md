<div align="center">

# 🫧 To-Do App

🚧 **This project is currently under active development!** 🚧</br>Some features may be incomplete or
unstable.

A To-Do app built using **Clean Architecture** and **XML**.

✨ **Migration to Jetpack Compose is planned!**

![Work In Progress](https://img.shields.io/badge/Status-WIP-yellow)

</div>

---

## 🛠️ **Tech Stack**

- **Languages**: Kotlin, XML
- **Architecture**: Clean Architecture (Data, Domain, Presentation)
- **Database**: Room Database
- **Other**: Coroutines, ViewModel, LiveData, Navigation Component

## 📁 Project Directory Structure

```
📦 ToDoApp
┣ 📂 data
┃ ┣ 📜 Converter.kt
┃ ┣ 📜 ToDoDao.kt
┃ ┣ 📜 ToDoDatabase.kt
┃ ┣ 📂 models
┃ ┃ ┣ 📜 Priority.kt
┃ ┃ ┗ 📜 ToDoData.kt
┃ ┣ 📂 repository
┃ ┃ ┗ 📜 ToDoRepository.kt
┃ ┗ 📂 viewmodel
┃   ┗ 📜 ToDoViewModel.kt
┣ 📂 presentation
┃ ┣ 📜 MainActivity.kt
┃ ┣ 📂 add
┃ ┃ ┗ 📜 AddFragment.kt
┃ ┣ 📂 core
┃ ┃ ┗ 📜 BaseFragment.kt
┃ ┣ 📂 list
┃ ┃ ┗ 📜 ListFragment.kt
┃ ┗ 📂 update
┃   ┗ 📜 UpdateFragment.kt
```
