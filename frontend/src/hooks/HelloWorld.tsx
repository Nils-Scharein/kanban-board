import {useEffect, useState} from "react";

const useHelloWorld = () => {
    const [answer, setAnswer] = useState<string>("Nothing Yet");
    const [error, setError] = useState<string>();

    useEffect(() => {

        const fetchHello = async ()=>
        {
            const url = "http://localhost:8080/hello"
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw new Error(`HTTP-Fehler: ${response.status}`);
                }
                const data = await response.text()
                console.log(data);
                setAnswer(data)
            } catch (error) {
                if (error instanceof Error) {
                    setError(error.message.toString())
                    console.error("Fehler:", error.message);
                }
            }
        }
        fetchHello()
    }, []);


    return {answer, error}
}

export default useHelloWorld
