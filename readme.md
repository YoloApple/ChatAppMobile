# 🟢 ChatAppFireBase | Kotlin | Firebase | MVVM

### ✍️ Developed by Dũng – 2025

Ứng dụng ChatAppFireBase là một ứng dụng nhắn tin cá nhân thời gian thực sử dụng Firebase làm nền tảng backend, được phát triển từ ý tưởng và kiến trúc của cộng đồng mã nguồn mở. Dự án này được chỉnh sửa, tối ưu và mở rộng nhằm phục vụ cho việc học tập, nghiên cứu và hoàn thiện kỹ năng lập trình Android của cá nhân.

---

## ✨ Những điểm đã hoàn thiện và cải tiến

- 🌐 Giao diện được điều chỉnh lại trực quan, thân thiện hơn
- 📱 Toàn bộ nội dung ứng dụng được Việt hóa
- 🔑 Đăng ký/đăng nhập bằng Firebase Authentication
- 🔍 Hiển thị danh sách người dùng từ Firestore
- 🧑‍🤝‍🧑 Gửi và nhận tin nhắn theo thời gian thực
- 🔔 Push Notification qua Firebase Cloud Messaging (FCM)
- 🎯 Áp dụng kiến trúc MVVM và Coroutine hiệu quả hơn

---

## 🛠️ Công nghệ sử dụng

- Firebase Authentication
- Firebase Firestore & Storage
- Firebase Cloud Messaging (FCM)
- MVVM Architecture
- Retrofit
- Kotlin Coroutines
- Navigation Component
- Two-way Data Binding

---

## 🔎 Firebase - Cấu trúc dữ liệu

### Collection: `Users`
```json
{
  "uid": "abc123xyz",
  "name": "Nguyễn Văn Dũng",
  "email": "dungbui0403@gmail.com",
  "image": "https://..."
}
