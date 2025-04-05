interface CabecalhoProps{
    ativo: "dashboard" | "ordem-servico" | "cadastrar" | "config"
}

import { SettingsIcon } from 'lucide-react'

export default function Cabecalho(props: CabecalhoProps) {
    const { ativo } = props
    const classAtiva = "border-b-3 border-primary"

  return (
    <nav className='flex justify-between items-center p-6 px-14 bg-gray-400'>
        <h1 className='text-4xl font-inter'>Auto<span className='text-primary'>Fix</span></h1>
        <ul className='flex gap-8 text-2xl'>
            <li className={ativo === "cadastrar" ? classAtiva : ""}>
                <a href="/cadastro">Cadastro</a>
            </li>
            <li className={ativo === "ordem-servico" ? classAtiva : ""}>
                <a href="/ordem-servico">Ordem de Serviço</a>
            </li>
            <li className={ativo === "dashboard" ? classAtiva : ""}>
                <a href="/dashboard">Dashboard</a>
            </li>
            <li className={`pl-15 ${ativo === "config" ? "text-white" : ""}`}>
                <a href="/configuracoes"><SettingsIcon/></a>
            </li>
        </ul>
    </nav>
  )
}
