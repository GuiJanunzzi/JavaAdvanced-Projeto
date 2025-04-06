"use client"
import { postOrdemServico } from '@/actions/ordem-servico-actions'
import Cabecalho from '@/components/Cabecalho'
import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { Select, SelectContent, SelectGroup, SelectItem, SelectLabel, SelectTrigger, SelectValue } from '@radix-ui/react-select'
import Link from 'next/link'
import  { useActionState } from 'react'

const initialState = {
  values:{
    descricao:"",
    valorTotal:0,
    status:""
  }
}

export default function OrdemServicoFormPage() {
  const [state, formAction, pending] = useActionState(postOrdemServico, initialState)

  return (
    <>
        <Cabecalho ativo="cadastrar"/>
        <main className='flex justify-center'>
            <div className='bg-gray-400 p-6 m-6 rounded min-w-1/3'>
                <h2>Cadastrar Ordem de Serviço</h2>
                <form action={formAction} >
                  <Input name='descricao' placeholder='Descrição' />
                  <Input name='valorTotal' placeholder='Valor Total' />
                  <Input name='status' placeholder='Status' />
                  
                  <div>
                    <Button variant="outline" asChild>
                      <Link href="/cadastro">
                        Cancelar
                      </Link>
                    </Button>
                    <Button>Salvar</Button>
                  </div>
                </form>
            </div>
        </main>
    </>
  )
}
