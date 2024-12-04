import { Menubar } from "primereact/menubar";

const Navigation = ({ isLoggedIn, onLogout }) => {
    const navList = isLoggedIn
        ? [
              {
                  label: "Home",
                  icon: "pi pi-fw pi-home",
                  command: () => {
                      window.location = "/";
                  },
              },
              {
                  label: "Add Customer",
                  icon: "pi pi-fw pi-user-plus",
                  command: () => {
                      window.location = "/addcustomer";
                  },
              },
              {
                label: "Show Customer",
                icon: "pi pi-fw pi-user",
                command: () => {
                    window.location = "/showcustomer";
                },
            },
            {
                label: "Create Order",
                icon: "pi pi-fw pi-cart-plus",
                command: () => {
                    window.location = "/orderform";
                },
            },
            {
                label: "Show Order",
                icon: "pi pi-fw pi-box",
                command: () => {
                    window.location = "/orderbycustomid";
                },
            },
              {
                  label: "Logout",
                  icon: "pi pi-fw pi-sign-out",
                  command: () => {
                      onLogout(); // Llama a la función de logout
                      window.location = "/login";
                  },
              },
          ]
        : [
              {
                  label: "Login",
                  icon: "pi pi-fw pi-sign-in",
                  command: () => {
                      window.location = "/login";
                  },
              },
              {
                  label: "Register",
                  icon: "pi pi-fw pi-user-edit",
                  command: () => {
                      window.location = "/register";
                  },
              },
          ];

    return (
        <div>
            <header>
                <nav>
                    <ul>
                        <Menubar model={navList} />
                    </ul>
                </nav>
            </header>
        </div>
    );
};

export default Navigation;
