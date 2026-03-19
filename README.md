# Backend

# OAUTH-SECURITY-KEYCLOAK project
- Auth server as Keycloak
- Authorization code Oauth flow based project was designed
- Role mapping also based can access the API's

  +----------+          (1) Authorize           +---------------+
|          |--------------------------------->|               |
|  User    |                                  |   Resource    |
|  Browser |<---------------------------------|    Owner      |
|          |          (2) Auth Code           |               |
+----------+                                  +---------------+
     |
     | (3) Redirect with Code
     v
+----------+          (4) Exchange Code       +---------------+
|          |--------------------------------->|               |
|  Client  |          (Token Request)         | Authorization |
|  App     |                                  |    Server     |
|          |<---------------------------------|               |
+----------+          (5) Access Token        +---------------+
     |                (and ID/Refresh Token)
     |
     v
+----------+          (6) Access Resource     +---------------+
|          |--------------------------------->|               |
| Resource |                                  |    Resource   |
| Server   |<---------------------------------|     API       |
+----------+          (7) Protected Data      +---------------+
