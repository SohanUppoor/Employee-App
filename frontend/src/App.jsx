import { useEffect, useState } from "react";

function App() {
  const [employees, setEmployees] = useState([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    fetch("http://localhost:8081/employees")
      .then(res => res.json())
      .then(data => setEmployees(data));
  }, []);

  const addEmployee = async () => {
    await fetch("http://localhost:8081/employees", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ name, email })
    });

    window.location.reload();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Add Employee</h2>
      <input
        placeholder="Name"
        onChange={e => setName(e.target.value)}
      />
      <input
        placeholder="Email"
        onChange={e => setEmail(e.target.value)}
      />
      <button onClick={addEmployee}>Save</button>

      <h2>Employees</h2>
      <ul>
        {employees.map(emp => (
          <li key={emp.id}>
            {emp.name} - {emp.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;