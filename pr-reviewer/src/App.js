import './App.css';
import  { useState } from 'react'

const API_KEY = API_KEY;
function App() {
  const [code,setCode]=useState("");
  const [review,setReview]=useState("");

  async function callOpenAIAPI(){
    console.log("code",code)
    const body = {
        "model": "gpt-3.5-turbo",
        "messages": [
          {
            "role": "system",
            "content": "You have to review code as developer and dont reveal yourself as reviewer"
          },
          {
            "role": "user",
            "content": `${code}`
          }
        ]
    }
    await fetch("API_URL",{
      method:"POST",
      headers:{
        "Content-Type": "application/json",
        "Authorization": `Bearer ${API_KEY}`
      },
      body: JSON.stringify(body)
    }).then((data)=> {
      return data.json()
    }).then((data)=> {
      console.log("data",data);
      setReview(data.choices[0].message.content);
      console.log("review",review )
    });
  }
  return (
    <div className="App">
      <div>
        <textarea
        onChange={(e)=> setCode(e.target.value)}
        placeholder="Paste your code here"
        cols={50}
        rows={10}/>
      </div>
      <div>
        <button onClick={callOpenAIAPI}>Get Review</button>
        {review  !== "" ?
          <h3>Review: {review} </h3>
          :
          null
        }
      </div>
    </div>
  );
}

export default App;
