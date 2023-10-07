import React from "react";
import App from "./App";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import ErrorPage from "./ErrorPage.js";
import Home from "./components/Home";
import { createRoot } from "react-dom/client";
import UserInfoCard from "./components/User/UserInfoCard";
import { ChakraProvider, extendTheme } from "@chakra-ui/react";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

import UserPage from "./components/User/UserPage";
const theme = extendTheme({
  config: {
    initialColorMode: "dark",
  },
});

const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route element={<App />}>
        <Route index element={<Home />} />
        <Route id="users" path="/users" element={<UserPage />}>
          <Route path=":id" element={<UserInfoCard />} />
        {/* <Route path="/users/:id/edit" element={<UserEditForm />} /> */}
        </Route>
        {/* <Route path="/customers" element={<CustomerPage />} /> */}
        {/* <Route path="/tickets" element={<ErrorPage />} /> */}
      </Route>
    </>,
  ),
);

const app = document.getElementById("app");

const root = createRoot(app);

root.render(
  <ChakraProvider theme={theme}>
    <QueryClientProvider client={new QueryClient()}>
      <RouterProvider
        router={router}
        fallbackElement={<ErrorPage />}
      ></RouterProvider>
    </QueryClientProvider>
  </ChakraProvider>,
);
