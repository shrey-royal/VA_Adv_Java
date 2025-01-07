<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register User</title>
    <!-- Include Material Design Lite CSS -->
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- Include Material Design Lite JavaScript -->
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
        }
        .mdl-layout__header {
            width: 100%;
        }
        .form-container {
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
            width: 320px;
            margin-top: 20px;
        }
        .form-container .mdl-button {
            width: 100%;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <!-- Title -->
                <span class="mdl-layout-title">Order Food</span>
                <!-- Spacer to align navigation to the right -->
                <div class="mdl-layout-spacer"></div>
                <!-- Navigation -->
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="user/list">List Food Items</a>
                    <a class="mdl-navigation__link" href="userLogin.jsp">Login</a>
                    <a class="mdl-navigation__link" href="userLogout.jsp">Logout</a>
                </nav>
            </div>
        </header>
    </div>

    <div class="form-container mdl-shadow--2dp">
        <form action="user/add" method="POST">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="username" name="username" required>
                <label class="mdl-textfield__label" for="username">Username</label>
            </div>

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="password" id="password" name="password" required>
                <label class="mdl-textfield__label" for="password">Password</label>
            </div>

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <select class="mdl-textfield__input" id="role" name="role">
                    <option value="user">User</option>
                    <option value="admin">Admin</option>
                </select>
                <label class="mdl-textfield__label" for="role">Role</label>
            </div>

            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" type="submit">
                Submit
            </button>
        </form>
    </div>
</body>
</html>
