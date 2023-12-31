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
import { ChakraProvider, extendTheme } from "@chakra-ui/react";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import {UserPage, UserInfoCard, } from "./components/User";
import { CustomerPage, CustomerInfoCard } from "./components/Customer";
import TicketPage from "./components/Ticket/TicketPage";
import TicketInfoCard from "./components/Ticket/TicketInfoCard";
import AddTicketForm from "./components/Ticket/AddTicketForm";
import {  MultiSelectTheme } from 'chakra-multiselect'

const theme = extendTheme({
  config: {
    initialColorMode: "dark",
  }, components: {
    MultiSelect: MultiSelectTheme
  }
});

const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route element={<App />}>
        <Route index element={<Home />} />
        <Route id="users" path="/users" element={<UserPage />}>
          <Route path=":id" element={<UserInfoCard />} />
        </Route>
        <Route path="/customers" element={<CustomerPage />}>
          <Route path=":id" element={<CustomerInfoCard />} />          
          </Route>




        <Route path="/tickets" element={<TicketPage />} />
        <Route path="/tickets/:id" element={<TicketInfoCard />} />
        <Route path="/tickets/add" element={<AddTicketForm />} />
      </Route>
    </>,
  ),
);

const app = document.getElementById("app");

const root = createRoot(app);


root.render(
  <ChakraProvider theme={theme}>
      <RouterProvider
        router={router}
        fallbackElement={<ErrorPage />}
      ></RouterProvider>
  </ChakraProvider>,
);

