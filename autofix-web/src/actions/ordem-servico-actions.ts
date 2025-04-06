import { redirect } from "next/navigation"


const API_URL = "http://localhost:8080/ordem-servico"

export async function getOrdemServico(): Promise<OrdemServico[]>{
    const response = await fetch(API_URL)
    
    return await response.json()
}

export async function postOrdemServico(initialState: any, formData: FormData){
    const dados = {
        descricacao: formData.get("descricao"),
        valorTotal: formData.get("valorTotal"),
        status: formData.get("status")
    }

    const options = {
        method: "POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(dados)
    }

    fetch(API_URL, options)

    redirect("/ordem-servico")
}